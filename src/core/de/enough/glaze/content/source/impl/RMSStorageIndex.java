/*
 *
 * Copyright: (c) 2012 Enough Software GmbH & Co. KG
 *
 * Licensed under:
 * 1. MIT: http://www.opensource.org/licenses/mit-license.php
 * 2. Apache 2.0: http://opensource.org/licenses/apache2.0
 * 3. GPL with classpath exception: http://www.gnu.org/software/classpath/license.html
 *
 * You may not use this file except in compliance with these licenses.
 *
 */
 
package de.enough.glaze.content.source.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

import de.enough.glaze.content.io.Serializer;
import de.enough.glaze.content.storage.StorageIndex;

public class RMSStorageIndex extends StorageIndex {
	static final String STORAGE = "RMSStorageIndex";
	static final int RECORD_UNKNOWN = Integer.MIN_VALUE;

	RecordStore store;
	int recordId = RECORD_UNKNOWN;

	public RMSStorageIndex() {
		super();

		try {
			// open the record store
			this.store = RecordStore.openRecordStore(STORAGE, true);
			RecordEnumeration recordEnumeration = this.store.enumerateRecords(
					null, null, false);
			
			if (recordEnumeration.hasNextElement()) {
				this.recordId = recordEnumeration.nextRecordId();
				
				//#debug debug
				System.out.println("index record id : " + this.recordId);
			}
			
		} catch (RecordStoreException e) {
			//#debug error
			System.out.println("unable to open record store " + e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zyb.nowplus.business.content.StorageIndex#load()
	 */
	protected Vector load() {
		try {
			if(this.recordId != RECORD_UNKNOWN)
			{
				// get the bytes
				byte[] bytes = store.getRecord(this.recordId);
				
				//deserialize the data
				ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
				Object data = Serializer.deserialize(new DataInputStream(byteStream));
				
				return (Vector)data;
			}
		} catch (IOException e) {
			//#debug error
			System.out.println("unable to read index " + e);
		}
		 catch (RecordStoreException e) {
			//#debug error
			System.out.println("unable to open record store " + e);
		}
		 
		 return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zyb.nowplus.business.content.StorageIndex#store(de.enough.polish.
	 * util.ArrayList)
	 */
	protected void store(Vector index) {
		try {
			// serialize the data and convert it to a byte array
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			Serializer.serialize(index, new DataOutputStream(byteStream));

			// get the bytes
			byte[] bytes = byteStream.toByteArray();
			
			if(this.recordId != RECORD_UNKNOWN)
			{
				// set the record
				store.setRecord(this.recordId, bytes, 0, bytes.length);
			}
			else
			{
				// add the record
				this.recordId = store.addRecord(bytes,0,bytes.length);
			}
		} catch (IOException e) {
			//#debug error
			System.out.println("unable to serialize index " + e);
		} catch (RecordStoreException e) {
			//#debug error
			System.out.println("unable to store index " + e);
		}
	}

	public void shutdown() {
		super.shutdown();

		try {
			store.closeRecordStore();
		} catch (RecordStoreException e) {
			//#debug error
			System.out.println("unable to close index " + e.toString());
		}
	}

}
