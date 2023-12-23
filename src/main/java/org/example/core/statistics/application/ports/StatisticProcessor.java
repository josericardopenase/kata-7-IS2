package org.example.core.statistics.application.ports;

import java.util.List;

public interface StatisticProcessor<S, M> {
    S process(List<M> data);

}
