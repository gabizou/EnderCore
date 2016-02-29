package com.enderio.core.client;

import com.enderio.core.client.render.IconUtil;
import com.enderio.core.common.CommonProxy;
import com.enderio.core.common.util.Scheduler;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
  private static final Scheduler scheduler = new Scheduler();

  @Override
  public Scheduler getScheduler() {
    return scheduler;
  }

  @Override
  public World getClientWorld() {
    return Minecraft.getMinecraft().theWorld;
  }

  @Override
  public void throwModCompatibilityError(String... msgs) {
    throw new EnderCoreModConflictException(msgs);
  }

  @Override
  public void onPreInit(FMLPreInitializationEvent event) {
    IconUtil.instance.init();
  }

}
