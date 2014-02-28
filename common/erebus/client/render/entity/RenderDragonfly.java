package erebus.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import erebus.client.model.entity.ModelDragonfly;
import erebus.entity.EntityDragonfly;

@SideOnly(Side.CLIENT)
public class RenderDragonfly extends RenderLiving {
	private static final ResourceLocation texture = new ResourceLocation("erebus:textures/entity/dragonflyGreen.png");

	public RenderDragonfly() {
		super(new ModelDragonfly(), 0.3F);
	}

	public void renderDragonfly(EntityDragonfly entityDragonfly, double x, double y, double z, float rotationYaw, float partialTickTime) {
		super.doRenderLiving(entityDragonfly, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float rotationYaw, float partialTickTime) {
		renderDragonfly((EntityDragonfly) entityLiving, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float rotationYaw, float partialTickTime) {
		renderDragonfly((EntityDragonfly) entity, x, y, z, rotationYaw, partialTickTime);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		GL11.glScalef(0.75F, 0.75F, 0.75F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
