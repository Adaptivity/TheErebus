package erebus.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import erebus.client.model.entity.ModelRhinoBeetle;
import erebus.entity.EntityRhinoBeetle;

public class RenderRhinoBeetle extends RenderLiving
{
	protected ModelRhinoBeetle model;
	private static final ResourceLocation[] textures = new ResourceLocation[] { new ResourceLocation("erebus:textures/entity/ModelRhinoBeetle.png"), new ResourceLocation("erebus:textures/entity/ModelRhinoBeetleKit.png") };

	public RenderRhinoBeetle(ModelRhinoBeetle modelBase, float shadowSize){
		super(modelBase, shadowSize);
		model =((ModelRhinoBeetle)mainModel);
	}
    public void renderRhinoBeetle(EntityRhinoBeetle entityRhinoBeetle, double x, double y, double z, float rotationYaw, float partialTickTime) {
        super.doRenderLiving(entityRhinoBeetle, x, y, z, rotationYaw, partialTickTime);
    }
    @Override
    public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float rotationYaw, float partialTickTime) {
        this.renderRhinoBeetle((EntityRhinoBeetle)entityLiving, x, y, z, rotationYaw, partialTickTime);
    }
    
    @Override
    public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float partialTickTime) {
        this.renderRhinoBeetle((EntityRhinoBeetle)entity, x, y, z, rotationYaw, partialTickTime);
    }
    
	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float partialTickTime) {
		scaleRhinoBeetle((EntityRhinoBeetle) entityliving, partialTickTime);
	}
	
	protected void scaleRhinoBeetle(EntityRhinoBeetle entityRhinoBeetle, float partialTickTime) {
		float size = 1.5F;
		GL11.glScalef(size, size, size);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		EntityRhinoBeetle beetle = (EntityRhinoBeetle) entity;
		if(beetle.getTameState()<2)
			return textures[0];
		else
			return textures[1];
	}
}