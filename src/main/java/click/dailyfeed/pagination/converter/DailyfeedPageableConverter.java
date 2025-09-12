package click.dailyfeed.pagination.converter;

import click.dailyfeed.code.global.web.page.DailyfeedPageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class DailyfeedPageableConverter implements PageableConverter {

    @Override
    public Pageable convert(DailyfeedPageable dailyfeedPageable) {
        int page = dailyfeedPageable.getPage();
        int size = dailyfeedPageable.getSize();
        String sort = dailyfeedPageable.getSort();

        if (sort != null && !sort.isEmpty()) {
            String[] sortParts = sort.split(",");
            String property = sortParts[0];
            String direction = sortParts.length > 1 ? sortParts[1] : "asc";

            Sort.Direction dir =
                    "desc".equalsIgnoreCase(direction) ?
                            Sort.Direction.DESC :
                            Sort.Direction.ASC;

            return PageRequest.of(page, size, Sort.by(dir, property));
        }
        return PageRequest.of(page, size);
    }
}
