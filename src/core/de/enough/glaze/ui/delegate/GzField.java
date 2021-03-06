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
 
package de.enough.glaze.ui.delegate;

import net.rim.device.api.ui.Graphics;

public interface GzField extends GzExtent {

	/**
	 * Must call FieldDelegate.invalidate(x, y, width, height) in an
	 * implementing field
	 * 
	 * @param x
	 *            the x offset
	 * @param y
	 *            the y offset
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public void invalidate(int x, int y, int width, int height);

	/**
	 * Must call FieldDelegate.layout(width, height, Field) in an implementing
	 * field
	 * 
	 * @param width
	 * @param height
	 */
	public void layout(int width, int height);

	/**
	 * Must call super.layout(width,height) in an implementing field
	 * 
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public void gz_layout(int width, int height);

	/**
	 * Must call super.paint(graphics) in an implementing field
	 * 
	 * @param graphics
	 *            the {@link Graphics} instance
	 */
	public void gz_paint(Graphics graphics);

	/**
	 * Must call super.invalidateAll(x,y,width,height) in an implementing field
	 * 
	 * @param x
	 *            the x offset
	 * @param y
	 *            the y offset
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public void gz_invalidateAll(int x, int y, int width, int height);
}
