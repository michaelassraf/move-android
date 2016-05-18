package com.lbis.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;

import com.lbis.enums.PathEnums;

public class LBiSFileUtils {
	static LBiSFileUtils instance;

	public static LBiSFileUtils getInstance() {
		if (instance == null) {
			instance = new LBiSFileUtils();
		}
		return instance;
	}

	public boolean isNavigeineDataExists() {
		if (new File(Environment.getExternalStorageDirectory()
				+ PathEnums.NAVIGENIE_PREFIX_FOLDER.getPathValue()).exists()) {
			return true;
		}
		return false;
	}

	public boolean patchAllNavgenieData(AssetManager assetManager) {
		try {
			String directory = Environment.getExternalStorageDirectory()
					+ PathEnums.NAVIGENIE_PREFIX_FOLDER.getPathValue();
			String zipFilePath = Environment.getExternalStorageDirectory()
					+ PathEnums.NAVIGENIE_PREFIX_FOLDER.getPathValue() + "/"
					+ PathEnums.NAVIGENIE_TEMP_FILE_NAME.getPathValue();
			String dataAssetName = PathEnums.NAVIGENIE_DATA_FILE_NAME
					.getPathValue();
			new File(directory).mkdirs();
			InputStream inputStream = assetManager.open(dataAssetName);
			OutputStream outputStream = new FileOutputStream(new File(
					zipFilePath));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			inputStream.close();
			outputStream.close();
			new ZipFile(zipFilePath).extractAll(directory);
			new File(zipFilePath).delete();
			return true;
		} catch (Throwable th) {
			return false;
		}
	}
}
