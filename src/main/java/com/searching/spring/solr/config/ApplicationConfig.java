package com.searching.spring.solr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fernandoabcampos on 08/04/15.
 */
@Configuration
@EnableSolrRepositories(basePackages={"com.searching.spring.solr.repository"}, multicoreSupport=true)
public class ApplicationConfig {

    private static final String SOLR_URL = "solr.url";
    private static final String SOLR_URL_DELTA_IMPORT = "solr.url_delta_import";
    private static final String SOLR_JOB_CRON = "scheduling.job.cron";

    @Resource
    private Environment environment;

    @Bean
    public SolrServer solrServer() {
//        String solrHost = environment.getRequiredProperty(SOLR_URL);
        String solrHost = "blablabla";
        return new HttpSolrServer(solrHost);
    }

    @Bean
    public String solrURL(){
        return "http://localhost:8081/solr";
//        return environment.getRequiredProperty(SOLR_URL);
    }

    @Bean
    public String solrURLDeltaImport(){
        return "http://localhost:8081/delta-import-solr";
//        return environment.getRequiredProperty(SOLR_URL_DELTA_IMPORT);
    }

    @Bean
    public String solrJobCron(){
        return "* * * *";
//        return environment.getRequiredProperty(SOLR_JOB_CRON);
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(1000*30);
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setConnectTimeout(1000*30);

        return restTemplate;
    }
}
