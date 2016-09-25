package trainings.binglas.trainingsession;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import trainings.binglas.trainingsession.adapters.ImageAdapter;
import trainings.binglas.trainingsession.event.RetrievePhotosEvent;
import trainings.binglas.trainingsession.event.RetrievePicSizesEvent;
import trainings.binglas.trainingsession.misc.GridAutofitLayoutManager;
import trainings.binglas.trainingsession.misc.LayoutManagerType;
import trainings.binglas.trainingsession.model.ModelPhoto;
import trainings.binglas.trainingsession.model.ModelSize;
import trainings.binglas.trainingsession.model.Photo;
import trainings.binglas.trainingsession.model.network.NetworkServiceManager;
import trainings.binglas.trainingsession.utils.Defines;

/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ItemListActivity extends EventBaseActivity {

    @Inject
    NetworkServiceManager mNetworkServiceManager;

    @Inject
    ModelPhoto mModelPhoto;

    @Inject
    ModelSize mModelSize;

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    //private PicturesAPI mServiceGenerator;
    private ProgressDialog progressDialog;
    private RecyclerView mRecyclerView;
    private List<Photo> mPhotoList;
    private ImageAdapter itemAdapter;
    private Bundle mBundle;
    private MenuItem menuGrid;
    private MenuItem menuList;
    private Boolean actionList = null;
    private Boolean actionGrid = null;
    private RecyclerView.LayoutManager mLayoutManager;
    protected LayoutManagerType mCurrentLayoutManagerType;

    private static final String KEY_LAYOUT_MANAGER = "layoutManager";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        mBundle = savedInstanceState;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (actionList == null) {
            actionList = Boolean.FALSE;
        }
        if (actionGrid == null) {
            actionGrid = Boolean.TRUE;
        }

        //mRecyclerView = ButterKnife.findById(this, R.id.item_list);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading images from Flickr. Please wait...");
        //progressDialog.show();

        View recyclerView = findViewById(R.id.recycler_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        //mRecyclerView = (RecyclerView) findViewById(R.id.recycler_list);
        //itemAdapter = new ImageAdapter(this, mModelPhoto.getPhotos());
        //mRecyclerView.setHasFixedSize(true);


        /*if (mRecyclerView != null) {
            setupRecyclerView(mRecyclerView);
        }*/
        /*mLayoutManager = new LinearLayoutManager(this);
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }

        mRecyclerView.setAdapter(itemAdapter);*/
        mNetworkServiceManager.retrievePublicPhotos();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //progressDialog.show();
                //mNetworkServiceManager.retrievePublicPhotos();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);

        if (tabletSize || mTwoPane) {
            recreate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_activity, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menuGrid = menu.findItem(R.id.action_grid).setVisible(actionGrid);
        menuList = menu.findItem(R.id.action_list).setVisible(actionList);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_grid:
                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
                item.setVisible(false);
                actionList = true;
                actionGrid = false;

                menuGrid.setVisible(actionGrid);
                menuList.setVisible(actionList);
                break;
            case R.id.action_list:
                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
                item.setVisible(false);
                actionList = false;
                actionGrid = true;

                menuGrid.setVisible(actionGrid);
                menuList.setVisible(actionList);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void handleClickAtRecyclerItem(ImageAdapter.ViewHolder pViewHolder) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            //arguments.putString(ItemDetailFragment.ARG_ITEM_ID, pViewHolder.mItem.id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, ItemDetailActivity.class);
            //intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, pViewHolder.mItem.id);

            startActivity(intent);
        }
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView != null) {
            if (mRecyclerView.getLayoutManager() != null) {
                scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                        .findFirstCompletelyVisibleItemPosition();
            }
        }

        if (itemAdapter == null) Log.e("_DEBUG_", "adapter a null");

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridAutofitLayoutManager(this, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 114,
                        getResources().getDisplayMetrics()));
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                if (itemAdapter != null) {
                    itemAdapter.setIsGrid(true);
                }
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                if (itemAdapter != null) {
                    itemAdapter.setIsGrid(false);
                }
                break;
            default:
                mLayoutManager = new LinearLayoutManager(this);
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                if (itemAdapter != null) {
                    itemAdapter.setIsGrid(false);
                }
        }

        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.scrollToPosition(scrollPosition);
        }
    }

    public void onEvent(RetrievePhotosEvent event) {
        //Log.d(Defines.TAG, "got photos:" + mModelPhoto.getPhotos());
        for (Photo photo : mModelPhoto.getPhotos()) {
            mNetworkServiceManager.retrievePhotosSizes(photo);
            itemAdapter.addItemAtTail(photo);
        }
    }

    public void onEvent(RetrievePicSizesEvent event) {
        //Log.d(Defines.TAG, "get Sizes : " + mModelSize.getSizes());
        //ImageAdapter imageAdapter = new ImageAdapter(this, mModelSize.getSizes());
        //mRecyclerView.setAdapter(imageAdapter);

        //setupRecyclerView(mRecyclerView);
        /*if (mRecyclerView != null) {
            setupRecyclerView(mRecyclerView);
        }*/
        itemAdapter.notifyDataSetChanged();
        //itemAdapter.notifyDataSetChanged();
        //itemAdapter.notifyDataSetChanged();
        //progressDialog.hide();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Log.i(Defines.TAG, "VAI FAZER O SETUP : "+mModelSize.getSizes().toString());
        itemAdapter = new ImageAdapter(this, mModelPhoto.getPhotos());
        recyclerView.setAdapter(itemAdapter);
        //setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save currently selected layout manager.
        outState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(outState);
    }


}
