package com.rescam.androidapp.bimx.utils.location;

import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

public class LocationUtils {

	private static String mLocationResult = null;

	public static void setLocation(String locationResult) {

		mLocationResult = locationResult;
	}

	public static String getLocation() {			
		return mLocationResult;
	}

	public static LocationClientOption getLocationClientOption() {

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Battery_Saving);// ���ö�λģʽ �߾�
		// option.setOpenGps(true);// ��gps
		option.setCoorType("gcj02");// ���صĶ�λ����ǰٶȾ�γ�ȣ�Ĭ��ֵgcj02
		option.setScanSpan(10000);// ���÷���λ����ļ��ʱ��Ϊ10��
		option.setIsNeedAddress(true);
		return option;
	}

}
