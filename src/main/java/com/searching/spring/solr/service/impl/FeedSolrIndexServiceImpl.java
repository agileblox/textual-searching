package com.searching.spring.solr.service.impl;

import com.searching.spring.solr.service.FeedSolrIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fernando on 09/04/15.
 */
@Service
public class FeedSolrIndexServiceImpl implements FeedSolrIndexService {

    private static final String SOLR_JOB_CRON = "0 0 * * * ?"; // every hour

    //TODO: This value and the way it receives a parameter for API will be adjusted
    private static final String URL_EXTERNAL_API = "https://ajax.googleapis.com/ajax/services/search/news?v=1.0&q=barack%20obama";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private String solrURLDeltaImport;

    @Override
    public void consultExternalAPIToFeedIndex() {

    }


    @Scheduled( cron = SOLR_JOB_CRON )
    @Override
    public void runIndex() {
            //TODO: review latter
            restTemplate.postForEntity(solrURLDeltaImport, null, null);

    }
}
