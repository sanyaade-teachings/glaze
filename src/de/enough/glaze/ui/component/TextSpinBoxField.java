package de.enough.glaze.ui.component;

import de.enough.glaze.ui.delegate.FieldDelegate;
import de.enough.glaze.ui.delegate.GzField;
import net.rim.device.api.ui.Graphics;

public class TextSpinBoxField extends
		net.rim.device.api.ui.component.TextSpinBoxField implements GzField {

	public TextSpinBoxField() {
		super();
	}

	public TextSpinBoxField(Object[] choices) {
		super(choices);
	}

	public TextSpinBoxField(Object[] choices, long style) {
		super(choices, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.rim.device.api.ui.component.Field#getPreferredWidth()
	 */
	public int getPreferredWidth() {
		return FieldDelegate.getPreferredWidth(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.rim.device.api.ui.component.Field#getPreferredHeight()
	 */
	public int getPreferredHeight() {
		return FieldDelegate.getPreferredHeight(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.rim.device.api.ui.component.LabelField#layout(int, int)
	 */
	public void layout(int width, int height) {
		FieldDelegate.layout(width, height, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.rim.device.api.ui.component.TextSpinBoxField#paint(net.rim.device
	 * .api.ui .Graphics)
	 */
	public void paint(Graphics graphics) {
		FieldDelegate.paint(graphics, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.enough.glaze.ui.component.GzField#gz_layout(int, int)
	 */
	public void gz_layout(int width, int height) {
		super.layout(width, height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.enough.glaze.ui.component.GzField#gz_paint(net.rim.device.api.ui.Graphics
	 * )
	 */
	public void gz_paint(Graphics graphics) {
		super.paint(graphics);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.enough.glaze.ui.component.GzField#gz_setExtent(int, int)
	 */
	public void gz_setExtent(int width, int height) {
		super.setExtent(width, height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.enough.glaze.ui.delegate.GzExtent#gz_getPreferredWidth()
	 */
	public int gz_getPreferredWidth() {
		return super.getPreferredWidth();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.enough.glaze.ui.delegate.GzExtent#gz_getPreferredHeight()
	 */
	public int gz_getPreferredHeight() {
		return super.getPreferredHeight();
	}
}
