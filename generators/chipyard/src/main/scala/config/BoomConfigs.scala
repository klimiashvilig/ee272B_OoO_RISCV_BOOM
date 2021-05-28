package chipyard

import freechips.rocketchip.config.{Config}

// ---------------------
// BOOM Configs
// ---------------------

class MinimalAbstractConfig extends Config(

  new chipyard.harness.WithPassthroughSimSPIFlashModel(false) ++       // add the SPI flash model in the harness (writeable)
  new chipyard.config.WithSPIFlash(0x100000) ++             // add the SPI flash controller (1 MiB)

  // new chipyard.config.WithNGPIO(3) ++                         // 3 GPIO pins
  // new chipyard.config.WithNSPI(4) ++                          // 1 SPIs, each supports 4 device
  new chipyard.config.WithI2C(1) ++                           // 1 I2C
  new chipyard.config.WithPWM ++                              // 1 PWM

  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new testchipip.WithBackingScratchpad(mask=((4 << 11) - 1)) ++// add mbus backing scratchpad 8kB
  new chipyard.config.AbstractConfig)

class LargeScratchPad extends Config(

  // new chipyard.harness.WithSimSPIFlashModel(false) ++       // add the SPI flash model in the harness (writeable)
  // new chipyard.config.WithSPIFlash(0x100000) ++             // add the SPI flash controller (1 MiB)

  new testchipip.WithDefaultSerialTL ++                          // use serialized tilelink port to external serialadapter/harnessRAM

  new chipyard.config.WithNGPIO(3) ++                         // 3 GPIO pins
  new chipyard.config.WithNSPI(4) ++                          // 1 SPIs, each supports 4 device
  new chipyard.config.WithI2C(1) ++                           // 1 I2C
  new chipyard.config.WithPWM ++                              // 1 PWM

  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new testchipip.WithBackingScratchpad(mask=((4 << 20) - 1)) ++// add mbus backing scratchpad 8kB
  new chipyard.config.AbstractConfig)

class MinimalAbstractConfig01 extends Config(
  new chipyard.harness.WithSimSPIFlashModel(false) ++       // add the SPI flash model in the harness (writeable)
  new chipyard.config.WithSPIFlash(0x100000) ++             // add the SPI flash controller (1 MiB)
  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new testchipip.WithBackingScratchpad(mask=((4 << 11) - 1)) ++                   // add mbus backing scratchpad
  new chipyard.config.WithL2TLBs(8) ++                        // use L2 TLBs
  new chipyard.config.AbstractConfig)

class DromajoMinimalAbstractConfig extends Config(
  // new testchipip.WithBackingScratchpad ++                   // add mbus backing scratchpad
  new chipyard.config.AbstractConfig)

class Minimal2kBL2AbstractConfig extends Config(
  new chipyard.MinimalAbstractConfig ++
  new freechips.rocketchip.subsystem.With2kBInclusiveCache)       // use 32kB, 4-way Sifive L2 cache

class Minimal2kBL2AbstractConfig01 extends Config(
  new chipyard.MinimalAbstractConfig01 ++
  new freechips.rocketchip.subsystem.With2kBInclusiveCache)       // use 32kB, 4-way Sifive L2 cache

class Minimal4kBL2AbstractConfig extends Config(
  new chipyard.MinimalAbstractConfig ++
  new freechips.rocketchip.subsystem.With2kBInclusiveCache(capacityKB=4))       // use 32kB, 4-way Sifive L2 cache

class LessMinimalAbstractConfig extends Config(
  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new testchipip.WithBackingScratchpad ++                   // add mbus backing scratchpad
  new chipyard.config.AbstractConfig)

class SuperMinimalAbstractConfig extends Config(
  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new freechips.rocketchip.subsystem.WithNoMMIOPort ++         
  new freechips.rocketchip.subsystem.WithNoSlavePort ++        
  new testchipip.WithBackingScratchpad ++                   // add mbus backing scratchpad
  new chipyard.config.AbstractConfig)

class MinimalSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.MinimalAbstractConfig)

class MinimalSmallBoom16kBL132kBL2Config extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

// Doesn't work
class MinimalSmallBoom16kBL12W32kBL2Config extends Config(
  new boom.common.WithNSmall16kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom8kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall8kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom4kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall4kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall1kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL2Config extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)





// ******************* Final **********************

class MinimalSmallBoom512B2WL12kBL2Config extends Config(
  new boom.common.WithNSmall512B2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom512B2WL14kBL2Config extends Config(
  new boom.common.WithNSmall512B2WBooms(1) ++                          // small boom config
  new chipyard.Minimal4kBL2AbstractConfig)

class Final extends Config(
  new boom.common.WithNSmall1kB2WBooms(1, 4) ++                          // small boom config
  new chipyard.MinimalAbstractConfig)

class FinalLargeScratchPad extends Config(
  new boom.common.WithNSmall1kB2WBooms(1, 4) ++                          // small boom config
  new chipyard.LargeScratchPad)

class MinimalSmallBoom001kB2WL1002kBL2008kBScratchConfig01 extends Config(
  new boom.common.WithNSmall1kB2WBooms(1, 4) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig01)









class MinimalSmallBoom1kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 2) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 4) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 8) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 16) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)




class MinimalSmallBoom2kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 2) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 4) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 8) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 16) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)




class MinimalMediumBoom1kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 2) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 4) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 8) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 16) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)




class MinimalMediumBoom2kB2Wi8kB4Wd32kBL22WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 2) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL24WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 4) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL28WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 8) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL216WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 16) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)




class MinimalSmallBoom1kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 0) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom2kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNSmall2kB2Wi8kB4WdBooms(1, 0) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom1kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 0) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom2kB2Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNMedium2kB2Wi8kB4WdBooms(1, 0) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)







// ****************************************************
// ************** Dcache victim cache *****************
// ****************************************************
class MinimalSmallBoom8kB4Wi1kB4WdConfig extends Config(
  new boom.common.WithNSmall8kB4Wi1kB4WdBooms(1) ++                          // small boom config
  new chipyard.LessMinimalAbstractConfig)

class MinimalSmallBoom8kB4Wi1kB2WdConfig extends Config(
  new boom.common.WithNSmall8kB4Wi1kB2WdBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB2WL1Config extends Config(
  new boom.common.WithNSmall1kB2WBooms(1, 4) ++                          // small boom config
  new freechips.rocketchip.subsystem.WithInclusiveCache ++       // use Sifive L2 cache
  new testchipip.WithBackingScratchpad ++                   // add mbus backing scratchpad
  new freechips.rocketchip.subsystem.WithNMemoryChannels(0) ++ // remove offchip mem port
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove backing memory
  new chipyard.config.AbstractConfig)

class MinimalSmallBoom8kB4Wi1kB2WdConfigWithDromajo extends Config(
  new chipyard.harness.WithSimDromajoBridge ++                   // attach Dromajo
  new chipyard.config.WithTraceIO ++                             // enable the traceio
  new boom.common.WithNSmall8kB4Wi1kB2WdBooms(1) ++                          // small boom config
  new chipyard.DromajoMinimalAbstractConfig)



// ****************************************************
// ************ Design space exploation ***************
// ****************************************************

// ****** 1-way

class WorkingMinimalSmallBoom8kB2WConfig extends Config(
  new boom.common.WithNSmall8kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom8kB4WConfig extends Config(
  new boom.common.WithNSmall8kB4WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom4kB4WConfig extends Config(
  new boom.common.WithNSmall4kB4WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom4kB2WConfig extends Config(
  new boom.common.WithNSmall4kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom2kB4WConfig extends Config(
  new boom.common.WithNSmall2kB4WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom2kB2WConfig extends Config(
  new boom.common.WithNSmall2kB2WBooms(1) ++
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom1kB4WConfig extends Config(
  new boom.common.WithNSmall1kB4WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalSmallBoom1kB2WConfig extends Config(
  new boom.common.WithNSmall1kB2WBooms(1) ++
  new chipyard.Minimal2kBL2AbstractConfig)


  // **** 2-way

class WorkingMinimalMediumBoom4kB4WConfig extends Config(
  new boom.common.WithNMediumBooms4kB4WL1(1) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalMediumBoom4kB2WConfig extends Config(
  new boom.common.WithNMediumBooms4kB2WL1(1) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalMediumBoom2kB4WConfig extends Config(
  new boom.common.WithNMediumBooms2kB4WL1(1) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalMediumBoom2kB2WConfig extends Config(
  new boom.common.WithNMediumBooms2kB2WL1(1) ++
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalMediumBoom1kB4WConfig extends Config(
  new boom.common.WithNMediumBooms1kB4WL1(1) ++                          // Medium boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class WorkingMinimalMediumBoom1kB2WConfig extends Config(
  new boom.common.WithNMediumBooms1kB2WL1(1) ++
  new chipyard.Minimal2kBL2AbstractConfig)



// **** Extra 1-way

class MinimalSmallBoom1kB4Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNSmall1kB4Wi8kB4WdBooms(1, 0) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom1kB4Wi8kB4Wd32kBL20WConfig extends Config(
  new boom.common.WithNMedium1kB4Wi8kB4WdBooms(1, 0) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalSmallBoom1kB4Wi8kB4Wd32kBL23WConfig extends Config(
  new boom.common.WithNSmall1kB2Wi8kB4WdBooms(1, 3) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class MinimalMediumBoom1kB4Wi8kB4Wd32kBL23WConfig extends Config(
  new boom.common.WithNMedium1kB2Wi8kB4WdBooms(1, 3) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)










class WorkingMinimalSmallBoom1kB2WL132kBL2Config extends Config(
  new boom.common.WithNSmall1kB2WBooms(1) ++                          // small boom config
  new chipyard.Minimal2kBL2AbstractConfig)

class SuperMinimalSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.SuperMinimalAbstractConfig)

class MinimalLargeBoom8kBL1Config extends Config(
  new boom.common.WithNLargeBooms8kBL1(1) ++                          // medium boom config
  new chipyard.MinimalAbstractConfig)

class SmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(1) ++                          // small boom config
  new chipyard.config.AbstractConfig)

class MediumBoomConfig extends Config(
  new boom.common.WithNMediumBooms(1) ++                         // medium boom config
  new chipyard.config.AbstractConfig)

class LargeBoomConfig extends Config(
  new boom.common.WithNLargeBooms(1) ++                          // large boom config
  new chipyard.config.AbstractConfig)

class MegaBoomConfig extends Config(
  new boom.common.WithNMegaBooms(1) ++                           // mega boom config
  new chipyard.config.AbstractConfig)

class DualSmallBoomConfig extends Config(
  new boom.common.WithNSmallBooms(2) ++                          // 2 boom cores
  new chipyard.config.AbstractConfig)

class HwachaLargeBoomConfig extends Config(
  new chipyard.config.WithHwachaTest ++
  new hwacha.DefaultHwachaConfig ++                              // use Hwacha vector accelerator
  new boom.common.WithNLargeBooms(1) ++
  new chipyard.config.AbstractConfig)

class LoopbackNICLargeBoomConfig extends Config(
  new chipyard.harness.WithLoopbackNIC ++                        // drive NIC IOs with loopback
  new icenet.WithIceNIC ++                                       // build a NIC
  new boom.common.WithNLargeBooms(1) ++
  new chipyard.config.AbstractConfig)

class DromajoBoomConfig extends Config(
  new chipyard.harness.WithSimDromajoBridge ++                   // attach Dromajo
  new chipyard.config.WithTraceIO ++                             // enable the traceio
  new boom.common.WithNSmallBooms(1) ++
  new chipyard.config.AbstractConfig)
