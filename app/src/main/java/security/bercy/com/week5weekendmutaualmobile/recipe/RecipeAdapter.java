package security.bercy.com.week5weekendmutaualmobile.recipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import security.bercy.com.week5weekendmutaualmobile.R;
import security.bercy.com.week5weekendmutaualmobile.model.Recipe;

/**
 * Created by Bercy on 1/17/18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{
    private Context context;
    private List<Recipe> recipeList = new ArrayList<>();
    private RecipeListItemListener listener;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.listener = (RecipeListItemListener) context;
        this.recipeList = recipeList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item
                , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Recipe recipe = recipeList.get(position);

        Picasso.with(context).load(recipe.getImage()).into(holder.recipeImage);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView recipeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.recipeImage);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            listener.onItemClicked(recipeList.get(getLayoutPosition()));

        }
    }


    interface RecipeListItemListener {
        void onItemClicked(Recipe recipe);
    }
}
