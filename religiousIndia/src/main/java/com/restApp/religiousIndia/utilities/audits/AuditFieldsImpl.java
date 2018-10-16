package com.restApp.religiousIndia.utilities.audits;

import org.springframework.data.domain.AuditorAware;

public class AuditFieldsImpl implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Abhi";
	}

}
