package com.lbis.move;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import uk.co.senab.photoview.PhotoView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockActivity;
import com.lbis.enums.PathEnums;
import com.lbis.utils.LBiSDateTime;
import com.lbis.utils.LBiSFileUtils;

public class BaseActivity extends SherlockActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mPlanetTitles;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (!LBiSFileUtils.getInstance().isNavigeineDataExists()) {
			new CreateNavigenieDataFolder().execute();
		}

		getSupportActionBar();
		ActionBarDrawerToggle mDrawerToggle11;
		String fff = new LBiSDateTime().toArray().toString();
		Log.i("sdasdsa", fff);
		PhotoView ss = new PhotoView(getApplicationContext());
	}

	class CreateNavigenieDataFolder extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			LBiSFileUtils.getInstance().patchAllNavgenieData(getAssets());
			return null;
		}

	}
}
