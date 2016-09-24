package trainings.binglas.trainingsession.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.ButterKnife;
import trainings.binglas.trainingsession.R;
import trainings.binglas.trainingsession.model.Photo;

/**
 * Created by joaozao on 24/09/16.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Photo> mPhotoList;

    public ImageAdapter(Context pContext, List<Photo> pPhotoList) {
        mContext = pContext;
        mPhotoList = pPhotoList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_test, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Picasso.with()
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageViewIcon;
        private View mView;

        public ViewHolder(View v) {
            super(v);

            mImageViewIcon = ButterKnife.findById(v, R.id.imageView);
            mView = v;
        }

        public ImageView getIcon() {
            return mImageViewIcon;
        }

        public View getView() {
            return mView;
        }
    }

}
