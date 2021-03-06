package org.jetlinks.community.elastic.search.index.strategies;

import org.hswebframework.utils.time.DateFormatter;
import org.jetlinks.community.elastic.search.ElasticRestClient;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 按月对来划分索引策略
 *
 * @author zhouhao
 * @since 1.0
 */
@Component
public class TimeByMonthElasticSearchIndexStrategy extends TemplateElasticSearchIndexStrategy {

    private final String format = "yyyy-MM";

    public TimeByMonthElasticSearchIndexStrategy(ElasticRestClient client) {
        super("time-by-month", client);
    }

    @Override
    public String getIndexForSave(String index) {
        return wrapIndex(index).concat("_").concat(DateFormatter.toString(new Date(), format));
    }
}
