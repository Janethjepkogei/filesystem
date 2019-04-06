import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;


@Value.Immutable
public interface File {
    String getName();
    List<Integer> getCounts();
    Optional<String> getDescription();

}
