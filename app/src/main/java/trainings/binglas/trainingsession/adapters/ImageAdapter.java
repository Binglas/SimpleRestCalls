package trainings.binglas.trainingsession.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import trainings.binglas.trainingsession.R;
import trainings.binglas.trainingsession.model.Size;
import trainings.binglas.trainingsession.utils.Defines;

/**
 * Created by joaozao on 24/09/16.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Size> mSizeList;

    public ImageAdapter(Context pContext, List<Size> pSizeList) {
        mContext = pContext;
        mSizeList = pSizeList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_test, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mList = mSizeList.get(position);
        Log.i(Defines.TAG, "recycler item ulr :  "+ mSizeList.get(position).getUrl());
        Log.i(Defines.TAG, "recycler holder icon :  "+ holder.getIcon());
        holder.getTextView().setText("Pic url : ".concat(mSizeList.get(position).getUrl()));
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                Log.d(Defines.TAG, "CLICKED ON ITEM");
            }
        });
        Picasso.with(mContext).load(mSizeList.get(position).getUrl()).into(holder.getIcon());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView mImageViewIcon;
        private View mView;
        public Size mList;

        public ViewHolder(View v) {
            super(v);
            mTextView = ButterKnife.findById(v, R.id.imageView);
            mImageViewIcon = ButterKnife.findById(v, R.id.imageView);
            mView = v;
        }

        public ImageView getIcon() {
            return mImageViewIcon;
        }

        public TextView getTextView() {
            return mTextView;
        }

        public View getView() {
            return mView;
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mTextView=" + mTextView +
                    ", mImageViewIcon=" + mImageViewIcon +
                    ", mView=" + mView +
                    ", mList=" + mList +
                    '}';
        }
    }

}
