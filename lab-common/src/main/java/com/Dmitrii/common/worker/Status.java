package com.Dmitrii.common.worker;

import java.io.Serializable;

/**
 *
 * Enum содержащий возможные статусы рабов.
 */
public enum Status implements Serializable {

	FIRED,
	RECOMMENDED_FOR_PROMOTION,
	PROBATION;
}
