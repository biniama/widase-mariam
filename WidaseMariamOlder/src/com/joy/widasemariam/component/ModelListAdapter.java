package com.joy.widasemariam.component;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.joy.widasemariam.model.AbstractModel;

public class ModelListAdapter extends ArrayAdapter<AbstractModel> {

	private final List<AbstractModel> modelList;
	
	@SuppressWarnings("unchecked")
	public ModelListAdapter(Context context, int textViewResourceId, List<?> modelList) {
		
		super(context, textViewResourceId);
		
		this.modelList = (List<AbstractModel>) modelList;
	}

	@Override
	public int getCount() {

		return null != modelList ? modelList.size() : 0;
	}

	@Override
	public AbstractModel getItem(int position) {
		
		if(null != modelList && position < modelList.size()){
			return modelList.get(position);
		}
		
		return null;
			
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getPosition(AbstractModel item) {
		
		if(null == item || modelList == null)
			return -1;
		
		return modelList.indexOf(item);
	}
	
	public int getPositionById(Object id) {
		
		if(null == id || modelList == null)
			return -1;
		
		final int numberOfItems = modelList.size();
		
		for(int i=0; i<numberOfItems; i++){
			
			if(id.equals(modelList.get(i).getId()))
				return i;
		}
		
		return -1;
	}	
}
