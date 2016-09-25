package trainings.binglas.trainingsession;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import trainings.binglas.trainingsession.event.RetrievePhotosEvent;
import trainings.binglas.trainingsession.event.RetrievePicSizesEvent;
import trainings.binglas.trainingsession.model.ModelPhoto;
import trainings.binglas.trainingsession.model.ModelSize;
import trainings.binglas.trainingsession.model.Photo;
import trainings.binglas.trainingsession.model.Size;
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
    private View mRecyclerView;
    private List<Photo> mPhotoList;
    private SimpleItemRecyclerViewAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        //mRecyclerView = ButterKnife.findById(this, R.id.item_list);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading images from Flickr. Please wait...");
        progressDialog.show();
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

        mRecyclerView = findViewById(R.id.item_list);


        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    public void onEvent(RetrievePhotosEvent event) {
        Log.d(Defines.TAG, "got photos:" + mModelPhoto.getPhotos());
        for (Photo photo : mModelPhoto.getPhotos()) {
            mNetworkServiceManager.retrievePhotosSizes(photo.getId());
        }
    }

    public void onEvent(RetrievePicSizesEvent event) {
        Log.d(Defines.TAG, "get Sizes : " + mModelSize.getSizes());
        //ImageAdapter imageAdapter = new ImageAdapter(this, mModelSize.getSizes());
        //mRecyclerView.setAdapter(imageAdapter);
        //setupRecyclerView(mRecyclerView);
        assert mRecyclerView != null;
        setupRecyclerView((RecyclerView) mRecyclerView);
        //itemAdapter.notifyDataSetChanged();
        //itemAdapter.notifyDataSetChanged();
        progressDialog.hide();
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Log.i(Defines.TAG, mModelSize.getSizes().toString());
        itemAdapter = new SimpleItemRecyclerViewAdapter(mModelSize.getSizes());
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        itemAdapter.notifyDataSetChanged();
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Size> mValues;

        public SimpleItemRecyclerViewAdapter(List<Size> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_test, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getUrl());
            //holder.mContentView.setText(mValues.get(position).content);
            String thumbnailUrl = mValues.get(0).getSource();
            Picasso.with(ItemListActivity.this).load(thumbnailUrl).into(holder.mImageView);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(Defines.TAG, "Clicked item ");
                    /*if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        ItemDetailFragment fragment = new ItemDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.item_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }*/
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final ImageView mImageView;
            //public final TextView mContentView;
            public Size mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.textView);
                mImageView = (ImageView) view.findViewById(R.id.imageView);
                //mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mIdView.getText() + "'";
            }
        }
    }
}
