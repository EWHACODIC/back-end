package ewhacodic.demo.domain.commitInfo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * ewhacodic.demo.domain.commitInfo.dto.QCommitMap is a Querydsl Projection type for CommitMap
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QCommitMap extends ConstructorExpression<CommitMap> {

    private static final long serialVersionUID = -824707917L;

    public QCommitMap(com.querydsl.core.types.Expression<Long> commitCount, com.querydsl.core.types.Expression<String> yyyymmdd) {
        super(CommitMap.class, new Class<?>[]{long.class, String.class}, commitCount, yyyymmdd);
    }

}

