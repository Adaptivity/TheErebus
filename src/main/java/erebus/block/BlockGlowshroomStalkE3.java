package erebus.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import erebus.ModBlocks;
import erebus.core.proxy.ClientProxy.BlockRenderIDs;

public class BlockGlowshroomStalkE3 extends Block{

	public BlockGlowshroomStalkE3() {
		super(Material.wood);
		setBlockBounds(0F, 0.3125F, 0.3125F, 0.6875F, 1F, 0.6875F);
	}

	@Override
	public int getRenderType() {
		return BlockRenderIDs.GLOWSHROOM_STALK.id();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return true;
	}
	
	@Override
	public void setBlockBoundsForItemRender() {
		setBlockBounds(0F, 0.3125F, 0.3125F, 0.6875F, 1F, 0.6875F);
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity) {
		setBlockBounds(0F, 0.3125F, 0.3125F, 0.6875F, 1F, 0.6875F);
		super.addCollisionBoxesToList(world, x, y, z, box, list, entity);
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 0;
	}

	@Override
	public Item getItemDropped(int id, Random random, int fortune) {
		return null;
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		return isValidBlock(world.getBlock(x - 1, y, z));
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return isValidBlock(world.getBlock(x - 1, y, z));
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		int meta = world.getBlockMetadata(x, y, z);
		boolean flag = false;
		if (isValidBlock(world.getBlock(x - 1, y, z)))
			flag = true;
		if (!flag) {
			breakBlock(world, x, y, z, neighbour, meta);
			world.setBlockToAir(x, y, z);
		}

		super.onNeighborBlockChange(world, x, y, z, neighbour);
	}

	private boolean isValidBlock(Block block) {
		return block == ModBlocks.glowshroomStalkWE2;
	}
}