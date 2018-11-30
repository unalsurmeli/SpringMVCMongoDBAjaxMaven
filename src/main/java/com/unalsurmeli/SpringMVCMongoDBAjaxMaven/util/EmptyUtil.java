package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util;

import java.io.Serializable;

public class EmptyUtil implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final boolean isEmpty(String string) {
		return string == null || string.trim().isEmpty();
	}

	public static final boolean isEmpty(Object obj) {
		return obj == null || obj.toString().trim().isEmpty();
	}
}
