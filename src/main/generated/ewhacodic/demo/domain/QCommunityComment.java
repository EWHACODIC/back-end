package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommunityComment is a Querydsl query type for CommunityComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommunityComment extends EntityPathBase<CommunityComment> {

    private static final long serialVersionUID = -2090287748L;

    public static final QCommunityComment communityComment = new QCommunityComment("communityComment");

    public final StringPath content = createString("content");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final NumberPath<Long> userCode = createNumber("userCode", Long.class);

    public QCommunityComment(String variable) {
        super(CommunityComment.class, forVariable(variable));
    }

    public QCommunityComment(Path<? extends CommunityComment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommunityComment(PathMetadata metadata) {
        super(CommunityComment.class, metadata);
    }

}

