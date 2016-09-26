package trainings.binglas.trainingsession;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import javax.inject.Inject;

import trainings.binglas.trainingsession.event.RetrievePicInfoEvent;
import trainings.binglas.trainingsession.model.network.NetworkServiceManager;
import trainings.binglas.trainingsession.model.photos.Photo;
import trainings.binglas.trainingsession.utils.Defines;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ItemListActivity}.
 */
public class ItemDetailActivity extends EventBaseActivity {

    @Inject
    NetworkServiceManager mNetworkServiceManager;
    private Photo photo;
    ItemDetailFragment fragment;
    private Bundle mSavedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSavedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        photo = getIntent().getExtras().getParcelable(Defines.PHOTO_PARCELABLE);
        Log.d("_DEBUG", "details activity photo with info : " + photo);

        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(photo.getTitle());
        }

        if (mSavedInstanceState == null) {
            mNetworkServiceManager.retrievePhotoInfo(photo);
        }

    }

    public void onEvent(RetrievePicInfoEvent event) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(Defines.PHOTO_PARCELABLE, photo);
        fragment = new ItemDetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, ItemListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
