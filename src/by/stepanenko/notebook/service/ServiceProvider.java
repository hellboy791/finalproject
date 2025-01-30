package by.stepanenko.notebook.service;

import by.stepanenko.notebook.service.impl.NotebookServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private final NotebookService service = new NotebookServiceImpl();
	
	public NotebookService getNotebookService() {
		return service;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}

}
