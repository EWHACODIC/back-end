package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQnaComment is a Querydsl query type for QnaComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQnaComment extends EntityPathBase<QnaComment> {

    private static final long serialVersionUID = -1115552863L;

    public static final QQnaComment qnaComment = new QQnaComment("qnaComment");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public QQnaComment(String variable) {
        super(QnaComment.class, forVariable(variable));
    }

    public QQnaComment(Path<? extends QnaComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQnaComment(PathMetadata metadata) {
        super(QnaComment.class, metadata);
    }

}

