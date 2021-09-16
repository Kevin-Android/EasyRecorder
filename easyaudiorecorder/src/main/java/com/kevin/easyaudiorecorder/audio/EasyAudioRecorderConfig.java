package com.kevin.easyaudiorecorder.audio;

import android.media.AudioFormat;
import android.media.AudioRecord;

/**
 * @author :    王康
 * @date :  2021/9/14
 * @desc :  录音配置
 */
public class EasyAudioRecorderConfig {

    /**
     * 录音源。
     */
    private int audioSource;
    /**
     * 以赫兹表示的采样率。
     */
    private int sampleRateInHz;
    /**
     * 描述了音频通道的配置。
     */
    private int channelConfig;
    /**
     * 要返回的音频数据的格式。
     */
    private int audioFormat;
    /**
     * 在录制期间写入音频数据的缓冲区的总大小（以字节为单位）。
     */
    private int bufferSizeInBytes;

    /**
     * 获取音频源
     *
     * @return 录音源
     */
    public int getAudioSource() {
        return audioSource;
    }

    /**
     * 获取以Hz为单位的采样率
     *
     * @return 采样率
     */
    public int getSampleRateInHz() {
        return sampleRateInHz;
    }

    /**
     * 获取频道配置
     *
     * @return 频道配置
     */
    public int getChannelConfig() {
        return channelConfig;
    }

    /**
     * 获取音频数据格式
     *
     * @return 音频数据格式
     */
    public int getAudioFormat() {
        return audioFormat;
    }

    /**
     * 以字节为单位获取缓冲区大小
     *
     * @return 缓冲区大小
     */
    public int getBufferSizeInBytes() {
        return bufferSizeInBytes;
    }


    /**
     * 设置音频源
     *
     * @param audioSource 音频源 有关录制源定义，请参阅 {@link android.media.MediaRecorder.AudioSource}。
     */
    public EasyAudioRecorderConfig setAudioSource(int audioSource) {
        this.audioSource = audioSource;
        return this;
    }

    /**
     * 以赫兹为单位设置采样率
     *
     * @param sampleRateInHz 采样率 44100Hz 是目前唯一保证适用于所有设备的速率，但其他速率（例如 22050、16000 和 11025）可能适用于某些设备。
     *                       {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED} 表示使用依赖于路由的值，通常是源的采样率。
     *                       {@link AudioFormat#getSampleRate()} 可用于检索所选的实际采样率。
     */
    public EasyAudioRecorderConfig setSampleRateInHz(int sampleRateInHz) {
        this.sampleRateInHz = sampleRateInHz;
        return this;
    }

    /**
     * 设置通道配置
     *
     * @param channelConfig 通道配置 请参阅
     *                      {@link AudioFormat#CHANNEL_IN_MONO},
     *                      {@link AudioFormat#CHANNEL_IN_STEREO},
     *                      {@link AudioFormat#CHANNEL_IN_MONO} 保证适用于所有设备。
     */
    public EasyAudioRecorderConfig setChannelConfig(int channelConfig) {
        this.channelConfig = channelConfig;
        return this;
    }

    /**
     * 设置要返回的音频数据的格式
     *
     * @param audioFormat 要返回的音频数据的格式 请参阅 {@link AudioFormat#ENCODING_PCM_8BIT}、{@link AudioFormat#ENCODING_PCM_16BIT} 和 {@link AudioFormat#ENCODING_PCM_FLOAT}。
     */
    public EasyAudioRecorderConfig setAudioFormat(int audioFormat) {
        this.audioFormat = audioFormat;
        return this;
    }

    /**
     * 以字节为单位设置缓冲区大小
     *
     * @param bufferSizeInBytes 缓冲区大小 可以从该缓冲区以比此大小更小的块读取新的音频数据。
     *                          请参阅 {@link AudioRecord#getMinBufferSize(int, int, int)} 以确定成功创建 AudioRecord 实例所需的最小缓冲区大小。
     *                          使用小于 getMinBufferSize() 的值将导致初始化失败。
     */
    public EasyAudioRecorderConfig setBufferSizeInBytes(int bufferSizeInBytes) {
        this.bufferSizeInBytes = bufferSizeInBytes;
        return this;
    }
}
