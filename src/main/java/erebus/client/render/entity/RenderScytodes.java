package erebus.client.render.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import erebus.client.model.entity.ModelScytodes;
import erebus.entity.EntityScytodes;

public class RenderScytodes extends RenderLiving {
	private static final ResourceLocation[] textures = new ResourceLocation[] { new ResourceLocation("erebus:textures/entity/scytodes1.png"), new ResourceLocation("erebus:textures/entity/scytodes2.png"), new ResourceLocation("erebus:textures/entity/scytodes3.png"), new ResourceLocation("erebus:textures/entity/scytodes4.png") };

	public RenderScytodes(ModelScytodes model, float shadowSize) {
		super(model, shadowSize);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entityliving, float f) {
		float f1 = 1.0F;
		shadowSize = f1;
		GL11.glScalef(f1, f1, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return textures[Math.min(textures.length - 1, ((EntityScytodes) entity).skin)];
	}
}