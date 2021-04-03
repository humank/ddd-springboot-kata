package solid.humank.dddpatterns.interfaces;


import solid.humank.dddpatterns.baseclasses.AggregateRoot;

@FunctionalInterface
public interface ISelector {

    public <T> T select(AggregateRoot aggregateRoot);
}
