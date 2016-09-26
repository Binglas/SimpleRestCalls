package trainings.binglas.trainingsession;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import trainings.binglas.trainingsession.model.photos.Photo;
import trainings.binglas.trainingsession.utils.Defines;


/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */

    private Photo photo;
    private ImageView mDetailsImageView;
    private TextView mOwner;
    private TextView mLocation;
    private TextView mType;
    private TextView mPosted;
    private TextView mTaken;
    private TextView mLastUpdated;
    private TextView mDescriptionDescription;

    /**
     * The dummy content this fragment is presenting.
     */
    //private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photo = getArguments().getParcelable(Defines.PHOTO_PARCELABLE);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        //if (mItem != null) {
           // ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
        //}

        Log.d(Defines.TAG, "photo on create view : " + photo);
        mDetailsImageView = (ImageView) rootView.findViewById(R.id.details_imageView);
        mOwner = (TextView) rootView.findViewById(R.id.owner_description);
        mLocation = (TextView) rootView.findViewById(R.id.location_description);
        mType = (TextView) rootView.findViewById(R.id.format_description);
        mPosted = (TextView) rootView.findViewById(R.id.posted_description);
        mTaken = (TextView) rootView.findViewById(R.id.taken_description);
        mLastUpdated = (TextView) rootView.findViewById(R.id.last_updated_description);
        mDescriptionDescription = (TextView) rootView.findViewById(R.id.desciption_description);

        Picasso.with(getActivity(this)).load(photo.getImageViewSize()).into(mDetailsImageView);
        mLocation.setText(photo.getLocation());
        mOwner.setText(photo.getUsername());
        mType.setText(photo.getOriginalFormat());
        mPosted.setText(photo.getPostedDateHR());
        mTaken.setText(photo.getTakenDate());
        mLastUpdated.setText(photo.getLastUpdatedHR());
        mDescriptionDescription.setText(photo.getDescription());

        return rootView;
    }

    /**
     * When inside a nested fragment and Activity gets recreated due to reasons like orientation
     * change, {@link android.support.v4.app.Fragment#getActivity()} returns old Activity but the top
     * level parent fragment's {@link android.support.v4.app.Fragment#getActivity()} returns current,
     * recreated Activity. Hence use this method in nested fragments instead of
     * android.support.v4.app.Fragment#getActivity()
     *
     * @param fragment
     *  The current nested Fragment
     *
     * @return current Activity that fragment is hosted in
     */
    public Activity getActivity(Fragment fragment) {
        if (fragment == null) {
            return null;
        }
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getActivity();
    }
}
