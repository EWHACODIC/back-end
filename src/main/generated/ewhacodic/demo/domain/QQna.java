package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQna is a Querydsl query type for Qna
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQna extends EntityPathBase<Qna> {

    private static final long serialVersionUID = -132125474L;

    public static final QQna qna = new QQna("qna");

    public final NumberPath<Long> commentCount = createNumber("commentCount", Long.class);

    public final ListPath<TechComment, QTechComment> comments = this.<TechComment, QTechComment>createList("comments", TechComment.class, QTechComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> recommend = createNumber("recommend", Long.class);

    public final StringPath tag = createString("tag");

    public final StringPath title = createString("title");

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public final NumberPath<Long> view = createNumber("view", Long.class);

    public QQna(String variable) {
        super(Qna.class, forVariable(variable));
    }

    public QQna(Path<? extends Qna> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQna(PathMetadata metadata) {
        super(Qna.class, metadata);
    }

}

