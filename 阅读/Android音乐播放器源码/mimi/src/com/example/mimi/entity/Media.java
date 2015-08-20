/**
 * 
 */
package com.example.mimi.entity;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ý���ļ���ʵ���࣬����ý���ļ�name��id, url, duration��
 */
public class Media implements Serializable {
	private String name;// ���õõ���������
	private String id;// ���ø������
	private String uri;// ���õõ�����·��
	private int duration;// ���õõ�����ʱ��
	private String singer;// ���õõ�������
	private int album_id;// ר��id
	private String album;
	private String key;
	private boolean love;// �����
	private boolean isplar;

	private int audioSessionId;// ��Ƶ�ỰID

	public Media() {

	}

	public Media(String name, String id, String uri, int duration,
			String singer, int album_id, String key, boolean love,
			int audioSessionId) {
		super();
		this.name = name;
		this.id = id;
		this.uri = uri;
		this.duration = duration;
		this.singer = singer;
		this.album_id = album_id;
		this.key = key;
		this.love = love;
		this.audioSessionId = audioSessionId;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public boolean isIsplar() {
		return isplar;
	}

	public void setIsplar(boolean isplar) {
		this.isplar = isplar;
	}

	public int getAudioSessionId() {
		return audioSessionId;
	}

	public void setAudioSessionId(int audioSessionId) {
		this.audioSessionId = audioSessionId;
	}

	public boolean isLove() {
		return love;
	}

	public void setLove(boolean love) {
		this.love = love;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Media [name=" + name + ", id=" + id + ", uri=" + uri
				+ ", duration=" + duration + ", singer=" + singer
				+ ", album_id=" + album_id + ", key=" + key + ", love=" + love
				+ "]";
	}

	public Media(Parcel in) {
		id = in.readString();
		name = in.readString();
		uri = in.readString();
		duration = in.readInt();
		singer = in.readString();
		album_id = in.readInt();
		key = in.readString();
	}

}
