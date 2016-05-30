/**
 * 
 */
package com.tower.service.rule.impl;

import com.tower.service.rule.IEngine;
import com.tower.service.rule.IFact;

/**
 * @author alexzhu
 * 
 */
public abstract class ManualDynamicEngine<T extends IFact> extends
		DynamicEngine<T> implements IEngine<T> {

	public ManualDynamicEngine() {
		super();
	}

	public void init() {
		try {
			this.setkContainer(getKieService().newKieContainer(
					getKieService().newReleaseId(this.getGroupId(),
							this.getArtifactId(), this.getVersion())));
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder(
					"fail to get maven rules kmodule from groupId: [");
			sb.append(getGroupId()).append("] artifactId: [")
					.append(getArtifactId()).append("] version: [")
					.append(getVersion()).append("]");
			// throw new NotExistsException(sb.toString());}
		}
	}

	public void refresh() {
		try {
			this.getContainer().updateToVersion(
					getKieService().newReleaseId(this.getGroupId(),
							this.getArtifactId(), this.getVersion()));
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder(
					"fail to get maven rules kmodule from groupId: [");
			sb.append(getGroupId()).append("] artifactId: [")
					.append(getArtifactId()).append("] version: [")
					.append(getVersion()).append("]");
			// throw new NotExistsException(sb.toString());  
		}

	}
}