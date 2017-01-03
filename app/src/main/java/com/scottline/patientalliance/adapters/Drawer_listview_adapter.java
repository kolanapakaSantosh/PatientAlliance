package com.scottline.patientalliance.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.scottline.patientalliance.R;
import com.scottline.patientalliance.activities.DrawerListItems;


public class Drawer_listview_adapter extends BaseAdapter {

	Context con;
	DrawerListItems[] obj = null;
	LayoutInflater inflator;

	public Drawer_listview_adapter(Context con, DrawerListItems[] obj)
	{
		this.con = con;
		this.obj = obj;
		inflator = (LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return obj.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView img = null;
		TextView name = null;
		/*if(convertView==null)
		{*/
			convertView = (View)inflator.inflate(R.layout.listview_item_row, null);
			 img = (ImageView)convertView.findViewById(R.id.imageViewIcon);
			 name = (TextView)convertView.findViewById(R.id.textViewName);
		//}
		Typeface type = Typeface.createFromAsset(con.getAssets(),"roboto_regular.ttf");
		name.setTypeface(type);
		DrawerListItems data = obj[position];

		img.setImageResource(data.icon);
		name.setText(data.name);
		name.setTag(data.name.replaceAll("\\s+",""));
		if(data.name.contains("/")) {
			name.setTag(data.name.replaceAll("\\s+","").replace("/",""));
		}


		return convertView;
	}

}
