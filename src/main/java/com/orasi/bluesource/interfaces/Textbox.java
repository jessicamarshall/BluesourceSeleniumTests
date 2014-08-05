package com.orasi.bluesource.interfaces;

import com.orasi.bluesource.core.TextboxImpl;
import com.orasi.bluesource.interfaces.impl.internal.ImplementedBy;

/**
 * Text field functionality.
 */
@ImplementedBy(TextboxImpl.class)
public interface Textbox extends Element {
	/*
	 * 	 * @see org.openqa.selenium.WebElement#clear()
	 */
	public void clear(); 

    /**
     * @param text The text to type into the field.
     */
    void set(String text);
    
    /**
     * @param text The text to type into the field.
     */
	void safeSet(String text);

    /* 
     * @see org.openqa.selenium.WebElement#getText()
     */
    public String getText();

}
