package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTech is a Querydsl query type for Tech
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTech extends EntityPathBase<Tech> {

    private static final long serialVersionUID = 199158492L;

    public static final QTech tech = new QTech("tech");

    public final NumberPath<Long> commentCount = createNumber("commentCount", Long.class);

    public final ListPath<TechComment, QTechComment> comments = this.<TechComment, QTechComment>createList("comments", TechComment.class, QTechComment.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> recommend = createNumber("recommend", Long.class);

    public final StringPath tag1 = createString("tag1");

    public final StringPath tag2 = createString("tag2");

    public final StringPath title = createString("title");

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public final NumberPath<Long> view = createNumber("view", Long.class);

    public QTech(String variable) {
        super(Tech.class, forVariable(variable));
    }

    public QTech(Path<? extends Tech> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTech(PathMetadata metadata) {
        super(Tech.class, metadata);
    }

}

