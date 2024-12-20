package com.crm.crm.Exception;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

public class ResourceNotFound extends RuntimeException{
	public ResourceNotFound(String msg) {
		super(msg);
	}

}
