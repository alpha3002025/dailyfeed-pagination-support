package click.dailyfeed.pagination.converter;

import click.dailyfeed.code.global.web.page.DailyfeedPageable;
import org.springframework.data.domain.Pageable;

public interface PageableConverter {
    Pageable convert(DailyfeedPageable dailyfeedPageable);
}
