package trainings.binglas.trainingsession.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import trainings.binglas.trainingsession.ItemListActivity;
import trainings.binglas.trainingsession.R;
import trainings.binglas.trainingsession.model.photos.Photo;
import trainings.binglas.trainingsession.utils.Defines;

/**
 * Created by joaozao on 24/09/16.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final Context mContext;
    private boolean mIsGrid;
    private List<Photo> mDataList;

    public ImageAdapter(Context pContext) {
        mContext = pContext;
        mDataList = new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("_DEBUG", "view type : " + viewType);
        View v = LayoutInflater.from(parent.getContext())
                .inflate(viewType == 0 ? R.layout.element_image : R.layout.element_image_grid, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                ((ItemListActivity) mContext).handleClickAtRecyclerItem(viewHolder);
                /*if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, viewHolder.mItem.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    .getSupportFragmentManager().beginTransaction()
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

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int colorResID = mContext.getResources().getColor(R.color.thumbnail_border_gray);
        holder.mItem = mDataList.get(position);
        //int colorResId = mContext.getResources().getColor(R.color.thumbnail_border_gray);
        //holder.mContentView.setText(mValues.get(position).content);
        //holder.mIdView.setText(mValuesPhoto.get(position).getTitle());
        String thumbnailListSizeUrl = holder.mItem.getThumbnailListSize();
        String thumbnailGridSizeUrl = holder.mItem.getThumbnailGridSize();

        Transformation transformation = new RoundedTransformationBuilder().borderColor(colorResID).borderWidthDp((float) 0.5).cornerRadiusDp(4).oval(false).build();
        final ArrayList<Transformation> empty = new ArrayList<>();
        final ArrayList<Transformation> nonEmpty = new ArrayList<>();
        nonEmpty.add(transformation);

        Log.i(Defines.TAG, "is Grid  : " + mIsGrid);
        Picasso.with(mContext).load(mIsGrid ? thumbnailGridSizeUrl:thumbnailListSizeUrl).transform(nonEmpty).error(R.drawable.beagle).fit().centerCrop().into(holder.getIcon());

        holder.getName().setText(mDataList.get(position).getTitle());
        if (holder.getDetails() != null) {
            holder.getDetails().setText(mIsGrid ? "" : "Olaa Details");
        }

        if (holder.getCloudIcon() != null) {
            holder.getCloudIcon().setVisibility(mIsGrid ? View.GONE:View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsGrid) return 1;
        else return 0;
    }

    public void setIsGrid(boolean pIsGrid) {
        mIsGrid = pIsGrid;
    }

    public void addItemAtTail(Photo pItem) {
        mDataList.add(pItem);
        if (mContext instanceof  ItemListActivity) {
            ((ItemListActivity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    notifyItemInserted(getItemCount() - 1);
                }
            });
        }
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewIcon;
        private TextView mTextViewName;
        private TextView mTextViewDetails;
        private ImageView mImageViewCloud;
        private View mView;
        //public final TextView mContentView;
        public Photo mItem;

        public ViewHolder(View view) {
            super(view);
            mImageViewIcon = ButterKnife.findById(view, R.id.item_icon);
            mTextViewName = ButterKnife.findById(view, R.id.item_name);
            mTextViewDetails = ButterKnife.findById(view, R.id.item_details);
            mImageViewCloud = ButterKnife.findById(view, R.id.item_cloud);
            mView = view;
        }

        public ImageView getIcon() {
            return mImageViewIcon;
        }

        public TextView getName() {
            return mTextViewName;
        }

        public TextView getDetails() {
            return mTextViewDetails;
        }

        public ImageView getCloudIcon() {
            return mImageViewCloud;
        }

        public View getView() {
            return mView;
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mImageViewIcon=" + mImageViewIcon +
                    ", mTextViewName=" + mTextViewName +
                    ", mTextViewDetails=" + mTextViewDetails +
                    ", mImageViewCloud=" + mImageViewCloud +
                    ", mView=" + mView +
                    ", mItem=" + mItem +
                    '}';
        }
    }
}