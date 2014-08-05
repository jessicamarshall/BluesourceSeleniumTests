package com.orasi.bluesource.interfaces;

import com.orasi.bluesource.interfaces.impl.ButtonImpl;
import com.orasi.bluesource.interfaces.impl.internal.ImplementedBy;

/**
 * Interface that wraps a WebElement in Button functionality. 
 */
@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {
	public void click();

}
