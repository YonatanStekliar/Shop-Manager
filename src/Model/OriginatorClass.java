package Model;

public class OriginatorClass implements Originator {
	private ProductMemento productMemento;

	public void setProduct(ProductMemento productMemento) {
		this.productMemento = productMemento;
	}

	@Override
	public MementoClass saveMemento() {
		return new MementoClass(productMemento);
	}

	public ProductMemento getProductMemento() {
		return productMemento;
	}

	public void getProductFromMemento(MementoClass memento) {
		productMemento = memento.restoreMemento();
	}

}
