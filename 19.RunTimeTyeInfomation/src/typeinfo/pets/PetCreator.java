package typeinfo.pets;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author denglitong
 * @date 2021/1/17
 */
public abstract class PetCreator implements Supplier<Pet> {
    private Random rand = new Random(47);

    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
