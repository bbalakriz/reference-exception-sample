package com.bala.emc_nems;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;


public class EMCRestWorkItemHandler extends RESTWorkItemHandler {
    private static final Logger logger = LoggerFactory.getLogger(EMCRestWorkItemHandler.class);

	public EMCRestWorkItemHandler(ClassLoader classLoader) {
		super(classLoader, false);
	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		try {
		    System.out.println("executing the custom work item handler");
		    logger.debug(getContentDataAsString(workItem.getParameters()));
			super.executeWorkItem(workItem, manager);
			logger.debug(workItem.getResults().toString());
		} catch (Exception e) {
		    System.out.println("Exception while executing the custom work item handler.........");
			throw new AllException(e.getCause());
		}
	}
	
	 private String getContentDataAsString(Map<String, Object> params) {
        String EMPTY_REQUEST_PAYLOAD = "The request payload is empty";
        Object content = EMPTY_REQUEST_PAYLOAD;

        if (params.containsKey(PARAM_CONTENT_DATA) && params.get(PARAM_CONTENT_DATA) != null) {
            content = params.get(PARAM_CONTENT_DATA);
            if (!(content instanceof String)) {
                content = transformRequest(content, getContentTypeAndCharset(params));
            }
        }

        return (String) content;
    }
    
	public EMCRestWorkItemHandler() {
	}

}