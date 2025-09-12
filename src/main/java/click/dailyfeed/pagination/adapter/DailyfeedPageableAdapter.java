package click.dailyfeed.pagination.adapter;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class DailyfeedPageableAdapter {
    public Pageable adapt() {
        return PageRequest.of(1,2);
    }
}
