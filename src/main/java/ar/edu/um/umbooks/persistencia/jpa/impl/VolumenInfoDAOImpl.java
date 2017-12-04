package ar.edu.um.umbooks.persistencia.jpa.impl;

import ar.edu.um.umbooks.clasesapi.VolumeInfo;

public class VolumenInfoDAOImpl extends DAOImpl<VolumeInfo, Integer> {
	public VolumenInfoDAOImpl() {
		super(VolumeInfo.class);
	}

	@Override
	public void create(VolumeInfo entity) {
		System.out.println("Paso por aca..");
		if (super.findById(entity.getId()) == null){
			
			super.create(entity);
		}	
	}
	
	
}
