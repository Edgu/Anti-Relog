package com.github.r0306.AntiRelog.NPC;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.v1_5_R3.AxisAlignedBB;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_5_R3.CraftWorld;

public class Node
{

	static List<Material> liquids = new ArrayList<Material>();
	
	static 
	{
		
		liquids.add(Material.WATER);
		liquids.add(Material.STATIONARY_WATER);
		liquids.add(Material.LADDER);

	}
	
	int f, g = 0, h;
	int xPos, yPos, zPos;
	Node parent;
	public Block b;
	boolean notsolid, liquid;
	
	public Node(Block b)
	{
	
		this.b = b;
		xPos = b.getX();
		yPos = b.getY();
		zPos = b.getZ();
		update();

	}
	
	public void update()
	{
	
		notsolid = true;
		
		if (b.getType() != Material.AIR)
		{
		
			AxisAlignedBB box = net.minecraft.server.v1_5_R3.Block.byId[b.getTypeId()].b(((CraftWorld) b.getWorld()).getHandle(), b.getX(), b.getY(), b.getZ());
		
			if (box != null)
			{
		
				if (Math.abs(box.e - box.b) > 0.2)
				{
	
					notsolid = false;
		
				}
		
			}
	
		}
		
		liquid = liquids.contains(b.getType());
	
	}

}


