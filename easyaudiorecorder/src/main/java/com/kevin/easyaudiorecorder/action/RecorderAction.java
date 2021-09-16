package com.kevin.easyaudiorecorder.action;

/**
 * @author : 王康
 * @date : 2021/9/14
 * @desc :
 */
public interface RecorderAction {

    /**
     * 准备录制 创建文件并准备录音。自动录音。
     *
     * @return 返回 boolean 的方法在成功时返回 true，在失败时返回 false。
     */
    boolean prepareToRecord();

    /**
     * 录音
     *
     * @return 返回 boolean 的方法在成功时返回 true，在失败时返回 false。
     */
    boolean record();


    /**
     * 在特定的时间执行录音
     *
     * @param atTime 回调应该运行的绝对时间，使用 {@link android.os.SystemClock#uptimeMillis} 时基。
     * @return 返回 boolean 的方法在成功时返回 true，在失败时返回 false。
     */
    boolean recordAtTime(long atTime);

    /**
     * 录音并指定持续时间
     *
     * @param forDuration 秒
     * @return 返回 boolean 的方法在成功时返回 true，在失败时返回 false。
     */
    boolean recordForDuration(long forDuration);

    /**
     * 在特定的时间执行录音并指定持续时间
     *
     * @param atTime      回调应该运行的绝对时间，使用 {@link android.os.SystemClock#uptimeMillis} 时基。
     * @param forDuration 秒
     * @return 返回 boolean 的方法在成功时返回 true，在失败时返回 false。
     */
    boolean recordAtTimeAndForDuration(long atTime, long forDuration);

    /**
     * 暂停录音
     */
    void pause();

    /**
     * 停止录音。关闭文件。
     */
    void stop();

    /**
     * 删除录制的文件。必须停止录音机。失败时返回 false。
     *
     * @return 返回 boolean 的方法在成功时返回 true，在失败时返回 false。
     */
    boolean deleteRecording();

    /**
     * 是否正在录音
     *
     * @return 返回 boolean 的方法在录音时返回 true，在没有录音时返回 false。
     */
    boolean isRecording();

    /**
     * 获取当前录音时间(仅在录音时有效)
     *
     * @return 当前录音时间
     */
    long getCurrentTime();

}
