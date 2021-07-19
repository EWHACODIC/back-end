package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTechComment is a Querydsl query type for TechComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTechComment extends EntityPathBase<TechComment> {

    private static final long serialVersionUID = 851897315L;

    public static final QTechComment techComment = new QTechComment("techComment");

    public final NumberPath<Long> commentId = createNumber("commentId", Long.class);

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public QTechComment(String variable) {
        super(TechComment.class, forVariable(variable));
    }

    public QTechComment(Path<? extends TechComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTechComment(PathMetadata metadata) {
        super(TechComment.class, metadata);
    }

}

