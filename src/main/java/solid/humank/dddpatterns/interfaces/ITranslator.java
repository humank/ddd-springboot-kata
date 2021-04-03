package solid.humank.dddpatterns.interfaces;

public interface ITranslator<O, I> {

    O translate(I transRequest);
}
