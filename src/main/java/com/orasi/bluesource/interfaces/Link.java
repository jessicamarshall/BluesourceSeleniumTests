package com.orasi.bluesource.interfaces;

import com.orasi.bluesource.interfaces.impl.LinkImpl;
import com.orasi.bluesource.interfaces.impl.internal.ImplementedBy;

/**
 * Interface that wraps a WebElement in Button functionality. 
 */
@ImplementedBy(LinkImpl.class)
public interface Link extends Element {
    
 
    public void click();
}
